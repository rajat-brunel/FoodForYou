<?php
    $con = mysqli_connect("localhost", "root", "Group@12", "food_for_you");
    
    $username = $_POST["username"];
    $password = md5($_POST["password"]);
    
    $statement = mysqli_prepare($con, "SELECT * FROM users WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $first_name, $last_name, $username, $password);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["first_name"] = $first_name;
        $response["last_name"] = $last_name;
        $response["username"] = $username;
    }
    
    echo json_encode($response);
?>