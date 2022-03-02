<?php

function brandService($requestMethod,$bodyRequest,$param){
    switch ($requestMethod) {
        case 'POST':
            $myDb = new DB();
            $newBrand = new Brand();
            $newBrand->jsonConstruct($bodyRequest);
            $newBrand->brandDB_insert($myDb->connection);
            return_response(200, "OK", new Response(ResponseCodes::$OK));
            break;

        case 'PUT':
            $myDb = new DB();
            $brandToPut = new Brand;
            $brandToPut->jsonConstruct($bodyRequest);
            $brandToPut->setBrand_id($param);
            $brandToPut->brandDB_update($myDb->connection);
            return_response(200, "OK", new Response(ResponseCodes::$OK));
            break;

        default:
            return_response(405, "Method Not Allowed", null);
            break;
     }
}
