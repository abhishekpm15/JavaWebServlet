
/**
 * 
 */
 
 function generateBtn(event){
	event.preventDefault();
	 console.log("Clicked");
	 let number = Math.ceil( Math.random() * 90000) + 10000;
	 console.log(number);
	 document.getElementById('id').value = number;
	 document.getElementById('generateBtn1').disabled = true;
	 document.getElementById('generateBtn1').style.backgroundColor = "grey";
	 return number;
 }

