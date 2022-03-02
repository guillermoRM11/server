<?php

class Brand implements \JsonSerializable{
    public int $brand_id;
    public string $name;
    public string $origin;
    
    public function parametersConstruct(int $brand_id, string $name, string $origin) {
        $this->brand_id = $brand_id;
        $this->name = $name;
        $this->origin =$origin;
    }
    public function jsonConstruct($json) {
        foreach (json_decode($json, true) AS $key => $value) {
            $this->{$key} = $value;
        }
    }
    
    public function brandDB_insert($dbconn){
        pg_prepare($dbconn, "my_query_INSERT", 'INSERT INTO brands (name,origin) VALUES ($1,$2) returning id;');
        $result = pg_execute($dbconn, "my_query_INSERT", array($this->name, $this->origin));
        while ($row = pg_fetch_row($result)) {
            $this->brand_id = $row[0];
        }
        // Free resultset Liberal la pool.
        pg_free_result($result);
    }
    
    public function brandDB_update($dbconn){
        $update = "UPDATE brands SET ";
        $fields = array();
        $values = array();
        if (isset($this->name)) {
            $fields[] = "name";
            $values[] = $this->name;
        }
        if (isset($this->origin)) {
            $fields[] = "origin";
            $values[] = $this->origin;
        }
       
        for ($i = 0; $i < count($fields); $i++) {
            $update .= $fields[$i]."=$".($i+1);
            if($i!=count($fields)-1){
                $update .= ",";
            }
        }
        $update .=  " WHERE id = $". (count($fields)+1); 
        
        $values[] = $this->brand_id;
        
        pg_prepare($dbconn, "my_query_UPDATE", $update);
        $result = pg_execute($dbconn, "my_query_UPDATE", $values);
        
        return $this;
    }

       public function jsonSerialize()
    {
        $vars = get_object_vars($this);

        return $vars;
    }
 

    function getBrand_id(): int {
        return $this->brand_id;
    }

    function getName(): string {
        return $this->name;
    }

    function getOrigin(): string {
        return $this->origin;
    }

    function setBrand_id(int $brand_id): void {
        $this->brand_id = $brand_id;
    }

    function setName(string $name): void {
        $this->name = $name;
    }

    function setOrigin(string $origin): void {
        $this->origin = $origin;
    }


}
