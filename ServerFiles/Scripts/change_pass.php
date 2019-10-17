<?php
    
	$con = mysqli_connect("localhost", "root", "Group@12", "food_for_you");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
	$change = $_POST["change"];
	
	
	function registerUser(){
	
		global $con, $username, $change;
		$encrypted_pass = md5($change);
		$statement = mysqli_prepare($con, "UPDATE `users` SET `password`= '$encrypted_pass' WHERE `username` = '$username'");
		mysqli_stmt_bind_param($statement, "ss", $username, $password);
		mysqli_stmt_execute($statement);
		mysqli_stmt_close($statement);
	}
   
   function checkpass() {
        global $con, $username, $password;
		$encrypted_pass = md5($password);
        $statement = mysqli_prepare($con, "SELECT * FROM `users` WHERE `username` = '$username' AND `password` = '$encrypted_pass'"); 
        mysqli_stmt_bind_param($statement, "ss", $username , $password);
        mysqli_stmt_execute($statement);
        mysqli_stmt_store_result($statement);
        $count = mysqli_stmt_num_rows($statement);
        mysqli_stmt_close($statement); 
        if ($count > 0){
		    return true; 
			echo $count;
        }else {
            return false; 
        }
    }
   
    $response = array();
    $response["success"] = false;  
	
	 if (checkpass()){
        registerUser();
        $response["success"] = true;  
    }
    
    echo json_encode($response);
?>