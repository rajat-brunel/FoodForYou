<?php
    $con = mysqli_connect("localhost", "root", "Group@12", "food_for_you");
    
    $post_code = $_POST["post_txt"];
	$p_code = substr($post_code, 0,3);
    
    $statement = mysqli_prepare($con, "SELECT * FROM `test_1` WHERE post_code LIKE '$p_code%'");
    mysqli_stmt_bind_param($statement, "sss", $name, $post_code, $img_res);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $filter_id, $name, $post_code, $img_res);
    
    $response['rest'] = array();
	$response["error"] = false;
   
    while(mysqli_stmt_fetch($statement)){
          
        $row_array['name'] = $name;
		$row_array['post_code'] = $post_code;
		$row_array['img_res']= $img_res;
		
		array_push($response['rest'],$row_array);
		 }
		 
		if(count($response['rest'])<1){
			$response["error"] = true;
		}
	echo json_encode($response);   
?>