function formValid(){
	var firstName = document.forms["signUpForm"]["firstname"].value;
	var middleName = document.forms["signUpForm"]["middlename"].value;
	var lastName = document.forms["signUpForm"]["lastname"].value;
	var idDocument = document.forms["signUpForm"]["idDocument"].value;
	var gender = document.forms["signUpForm"]["gender"].value;
	var phone = document.forms["signUpForm"]["phone"].value;
	var address = document.forms["signUpForm"]["address"].value;
	var email = document.forms["signUpForm"]["email"].value;
	var password1 = document.forms["signUpForm"]["pass"].value;
	
	if (firstName ==""){
		alert("Please, type your First Name!");
		return false;
	} else if (middleName ==""){
		alert("Please, type your Middle Name!");
		return false;
	} else if (lastName ==""){
		alert("Please, type your Last Name!");
		return false;
	}else if (idDocument ==""){
		alert("Please, type your ID!");
		return false;
	}else if (gender ==""){
		alert("Please, type your Gender!");
		return false;
	}else if (phone ==""){
		alert("Please, type your Phone Number!");
		return false;
	}else if (address ==""){
		alert("Please, type your Full Address!");
		return false;
	}else if (email ==""){
		alert("Please, type a valid email!");
		return false;
	}else if (password1 ==""){
		alert("Please, type a valid Password!");
		return false;
	}else{
		return true;
	}
}

function checkForm(form)
  {
    ...
    if(!form.terms.checked) {
      alert("Please indicate that you accept the Terms and Conditions");
      form.terms.focus();
      return false;
    }
    return true;
  }


