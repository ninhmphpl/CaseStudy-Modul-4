function login(){
    let email = document.getElementById("email").value
    let password = document.getElementById("password").value
    let data = {
        email:email,
        password:password
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/api/login",
        data: JSON.stringify(data),
        success: function (data) {
            sessionStorage.setItem("token", JSON.stringify(data))
            window.location = sessionStorage.getItem("doing")
            console.log(data)
        },
        error: function (data){
            document.getElementById("message").innerText = "Tài khoản mật khẩu không chính xác"
        }
    })
    event.preventDefault();

}
// sessionStorage.setItem("doing", "http://localhost:63342/web/web.main/templates/themes.TechJobs/client/login.html")