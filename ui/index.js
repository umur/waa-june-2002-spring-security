 async function loginUser() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
      
    let bodyJson = { 
        "email": email, "password": password
    }
    
    const rawResponse = await fetch(`http://127.0.0.1:8080/api/v1/uaa`, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(bodyJson)
    });
    if(rawResponse.ok){
        console.log(rawResponse.json())
    }
    
  }
  
  

  


  