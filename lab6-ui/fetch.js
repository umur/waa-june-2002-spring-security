// $(document).ready(function () {
//   $("#view_button").click(function () {
//     var url = "https://api.nasa.gov/planetary/apod?api_key=GE5r6C7fP26s1Ta8sSkFkoJtNrvAdddi4FsCj1wS&date="+$("#date").val();   
//     fetch(url, {
//       method: "GET"      
//     })
//       .then((res) => {
//         return res.json();
//       })
//       .then((data) => {
//         $("#title").html(data.title);
//         $("#explanation").html(data.explanation);
//         $("#pic").attr("src", data.url);
//       })
//       .catch(function (error) {      
//         console.log("Request failed", error);
//         alert(error.responseText);
//       });
//   });
// });



function signin(){
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;
  var url = "http://localhost:8080/api/v1/uaa"; 


  fetch('http://localhost:8080/api/v1/uaa', {
    method: 'POST',
    headers: {
      'Accept': 'application/json, text/plain, */*',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({email: email, password: password})
  }).then(res => res.json())
    .then(res => {     
      var rs = JSON.stringify(res);
      if(rs = ""){
        alert("email or password is wrong");
      }else{
        window.location.href="/success.html"      
      }     
    }).catch(function (error) {  
      alert("email or password is wrong");    
    });
 
}

function signup(){
  fetch('http://localhost:8080/api/v1/uaa/signup', {
    method: 'POST',
    headers: {
      'Accept': 'application/json, text/plain, */*',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({})
  }).then(res => res.json())
    .then(res => {     
      window.location.href="/fetch.html"
      console.log(JSON.stringify(res))
    }).catch(function (error) {  
      alert(error);    
    });
  
}

function getAllProducts(){
    var url = "http://localhost:8080/api/v1/products/All";   
  fetch(url, {
    method: "GET"      
  })
    .then((res) => {      
      return res.json();
    })
    .then((data) => {
      alert(JSON.stringify(data))
      document.getElementById("rs").value = JSON.stringify(data)
    })
    .catch(function (error) {
      console.log("Request failed", error);
      //alert(error.responseText);
    });
}
