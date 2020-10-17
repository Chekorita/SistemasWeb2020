var blogeo = document.getElementById("signIn");
blogeo.addEventListener("click",function () {
    const parametros = new URLSearchParams();
    parametros.append('Prtemail',document.getElementById("email").value);
    parametros.append('Prtpassword',document.getElementById("password").value);
//llamada get
    // axios.get('http://127.0.0.1:4567/hello/'+parametros,{
    //     PrtEmail : document.getElementById('email').value,
    //     Prtpassword : document.getElementById('password').value
    // })
    // .then(function(response){
    //     console.log(response);
    //     console.log(response.data);
    //     console.log(response.statusText);
    //     document.getElementById('titulos').innerHTML = response.data
    // })
    // .catch(function(error){
    //     console.log(error)
    // });
//llamada post que envia un objeto json, como aplication json
    // axios.post('http://127.0.0.1:4567/json',{
    //     PrtEmail : document.getElementById('email').value,
    //     Prtpassword : document.getElementById('password').value
    // })
    // //anterior se envia como json
    // .then(function(response){
    //     console.log(response);
    //     console.log(response.data);
    //     console.log(response.statusText);
    //     document.getElementById('titulos').innerHTML = response.data
    // })
    // .catch(function(error){
    //     console.log(error)
    // })

    //llamada post que envia un objeto json, como aplication www.mas es el malo
    // axios.post('http://127.0.0.1:4567/fromdata', parametros,{
    //     PrtEmail : document.getElementById('email').value,
    //     Prtpassword : document.getElementById('password').value
    // })
    // .then(function(response){
    //     console.log(response);
    //     console.log(response.data);
    //     console.log(response.statusText);
    //     document.getElementById('titulos').innerHTML = response.data
    // })
    // .catch(function(error){
    //     console.log(error)
    // })

    axios.get('http://127.0.0.1:4567/queryparams?'+parametros,{
        PrtEmail : document.getElementById('email').value,
        Prtpassword : document.getElementById('password').value
    })
    .then(function(response){
        console.log(response);
        console.log(response.data);
        console.log(response.statusText);
        document.getElementById('titulos').innerHTML = response.data
    })
    .catch(function(error){
        console.log(error)
    })
});