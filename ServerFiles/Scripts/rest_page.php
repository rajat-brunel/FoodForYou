<?php
    $con = mysqli_connect("localhost", "root", "Group@12", "food_for_you");
    
    
	$res = $_POST["res"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM `rest_db` WHERE res_name='$res'");
    mysqli_stmt_bind_param($statement, "ssss", $res_name, $res_logo, $res_type, $res_post);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $res_id, $res_name, $res_logo, $res_type, $res_post, $res_menu, $res_bck_img);
    
    $response['rest'] = array();
	$response["error"] = false;
	
   
    while(mysqli_stmt_fetch($statement)){
          
        $row_array['name']= $res_name;
		$row_array['logo']= $res_logo;
		$row_array['type']= $res_type;
		$row_array['post']= $res_post;
		$row_array['menu']= $res_menu;
		$row_array['bck'] = $res_bck_img;
		
		array_push($response['rest'],$row_array);
		 }
		 
		if(count($response['rest'])<1){
			$response["error"] = true;
		}
	echo json_encode($response);   
?>