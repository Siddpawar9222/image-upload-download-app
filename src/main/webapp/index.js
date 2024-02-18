const validateFileType = () => {
	var fileInput = document.getElementById("formFileLg")
	var errormg = document.getElementById("errormg");
	var file = fileInput.files[0]; 
	var fileSize = file.size;      
	if (fileSize <= 200 * 1024) { 
		errormg.innerHTML ="" ;
		return;
	} else {
		errormg.innerHTML ="*File size exceeds the maximum limit of 200KB!*" ;
		fileInput.value = ""; 
		
	}
}