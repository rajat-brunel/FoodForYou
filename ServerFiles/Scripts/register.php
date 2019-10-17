<?php
    
	$con = mysqli_connect("localhost", "root", "Group@12", "food_for_you");
    
    $first_name = $_POST["first_name"];
    $last_name = $_POST["last_name"];
    $username = $_POST["username"];
    $password = $_POST["password"];
	
	
	function registerUser(){
	
		global $con, $first_name, $last_name, $username, $password;
		$encrypted_pass = md5($password);
		$statement = mysqli_prepare($con, "INSERT INTO `users` (`user_id`, `first_name`, `last_name`, `username`, `password`) VALUES (NULL, '$first_name', '$last_name', '$username', '$encrypted_pass')");
		mysqli_stmt_bind_param($statement, "ssss", $first_name, $last_name, $username, $password);
		mysqli_stmt_execute($statement);
		mysqli_stmt_close($statement);
	}
   
   function usernameAvailable() {
        global $con, $username;
        $statement = mysqli_prepare($con, "SELECT * FROM `users` WHERE `username` = '$username'"); 
        mysqli_stmt_bind_param($statement, "s", $username);
        mysqli_stmt_execute($statement);
        mysqli_stmt_store_result($statement);
        $count = mysqli_stmt_num_rows($statement);
        mysqli_stmt_close($statement); 
        if ($count < 1){
		    return true; 
        }else {
            return false; 
        }
    }
   
    $response = array();
    $response["success"] = false;  
	
	 if (usernameAvailable()){
        registerUser();
        $response["success"] = true;  
    }
    
    echo json_encode($response);
?>