<?php

class Product implements \JsonSerializable { //Parece que es paraa pasan a Json
    //Se declaran con $ y string en minusculas
    public string $name;
    public int $price;
    public int $stock;
    public int $gender;
    public int $id;
    
    //Fuera de BBDD
    public int $quantity;
    
    //Para poder llenar las instancias que se creen de la clase. Los constructores estan abajo
    public function parametersConstruct(int $id, string $name,int $price,int $stock,int $gender) {
        $this->name = $name;
        $this->stock = $stock;
        $this->price = $price;
        $this->gender = $gender;
        $this->id = $id;
    }
    //Parece que se usa para convertir los json en mapas clave-valor
    public function jsonConstruct($json) {
        foreach (json_decode($json, true) AS $key => $value) {
            $this->{$key} = $value;
        }
    }

    //Los prepareStatement se gacen con pg. Las consultas sql se guardan en my_query_INSERT. En vez de Db myDb es $dbcon. En vez de ? es $1
    //Se guardan los resultados $result, que se convierte a un array
    //Se hace el homonimo de while rs.next y se xogen los id
    //Para terminar, se libera la pool
    public function DB_insert($dbconn){
        pg_prepare($dbconn, "my_query_INSERT", 'INSERT INTO products (name,price,stock,gender) VALUES ($1,$2,$3,$4) returning id;');
        $result = pg_execute($dbconn, "my_query_INSERT", array($this->name, $this->price,$this->stock, $this->gender));
        while ($row = pg_fetch_row($result)) {
            $this->id = $row[0];
        }
        // Free resultset Liberal la pool.
        pg_free_result($result);
    }
    
    public static function DB_selectAll($dbconn){
        pg_prepare($dbconn, "my_query_SELECTALL", 'SELECT id,name,price,stock,gender FROM products;');
        $result = pg_execute($dbconn, "my_query_SELECTALL",array()); //Si no se ponen $1 etc el array parece que esta vacio 
        $products = array();
        while ($row = pg_fetch_row($result)) {
            $newProduct = new Product;
            $newProduct->parametersConstruct($row[0],$row[1],$row[2],$row[3],$row[4]); //Se llena la clase Product con parametersConstruct
            $products[]=$newProduct;
        }
        // Free resultset
        pg_free_result($result);
        return $products;
    }
    
    //Para el update para una fucncion mas sencilla. Se recoge la consulta en $update y se pone al final
    public function DB_update($dbconn){
        $update = "UPDATE products SET ";
        $fields = array();
        $values = array();
    //Si las variables no son nulas, pone en un array la clave y en otro el valor
        if (isset($this->name)) {
            $fields[] = "name";
            $values[] = $this->name;
        }
        if (isset($this->price)) {
            $fields[] = "price";
            $values[] = $this->price;
        }
        if (isset($this->stock)) {
            $fields[] = "stock";
            $values[] = $this->stock;
        }
        if (isset($this->gender)) {
            $fields[] = "gender";
            $values[] = $this->gender;
        }
    //El punto concatena los strings. Coge el elemento clave valor de los arrays y completa la sentencia de update para realizarla abajo
        for ($i = 0; $i < count($fields); $i++) {
            $update .= $fields[$i]."=$".($i+1);
            if($i!=count($fields)-1){
                $update .= ",";
            }
        }
        $update .=  " WHERE id = $". (count($fields)+1); //UPDATE products SET array[i] = $i+1 WHERE id = $
        
        $values[] = $this->id;
        
        pg_prepare($dbconn, "my_query_UPDATE", $update);
        $result = pg_execute($dbconn, "my_query_UPDATE", $values);
        
        return $this;
    }
    
    public function DB_buyProduct($dbconn){
        pg_prepare($dbconn, "my_query_BUYPRODUCT", 'UPDATE products SET stock = stock - $1 WHERE id = $2 AND stock >= $1 ;');
        $result = pg_execute($dbconn, "my_query_BUYPRODUCT",array($this->quantity,$this->id));
    //Coge el numero de filas afectadas por esta consulta
        if(pg_affected_rows($result)===0){
            return ResponseCodes::$ERROR;
        }else{
            return ResponseCodes::$OK;
        }
        pg_free_result($result);
    }
    
    public static function DB_selectAllGender($dbconn,$gender){
        pg_prepare($dbconn, "my_query_SELECTALLGENDER", 'SELECT id,name,price,stock,gender FROM products WHERE gender = $1;');
        $result = pg_execute($dbconn, "my_query_SELECTALLGENDER",array($gender));
        $products = array();
        while ($row = pg_fetch_row($result)) {
            $newProduct = new Product;
            $newProduct->parametersConstruct($row[0],$row[1],$row[2],$row[3],$row[4]);
            $products[]=$newProduct;
        }
        // Free resultset
        pg_free_result($result);
        return $products;
    }
       
    
    
    //Para que las variables privadas de clase también se conviertan a json
    public function jsonSerialize()
    {
        $vars = get_object_vars($this);

        return $vars;
    }
    public function getName(): string {
        return $this->name;
    }

    public function getPrice(): int {
        return $this->price;
    }

    public function getStock(): int {
        return $this->stock;
    }

    public function getGender(): int {
        return $this->gender;
    }

    public function getId(): int {
        return $this->id;
    }

    public function setName(string $name): void {
        $this->name = $name;
    }

    public function setPrice(int $price): void {
        $this->price = $price;
    }

    public function setStock(int $stock): void {
        $this->stock = $stock;
    }

    public function setGender(int $gender): void {
        $this->gender = $gender;
    }

    public function setId(int $id): void {
        $this->id = $id;
    }

    public function getQuantity(): int {
        return $this->quantity;
    }

    public function setQuantity(int $quantity): void {
        $this->quantity = $quantity;
    }
}
