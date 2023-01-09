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
            setToken(data)
            backPage()
            console.log(data)
        },
        error: function (jqXHR, textStatus, errorThrown){
            console.log("mã lỗi: " + jqXHR.status)
            console.log("Text: " + textStatus)
            console.log("Thrown: " + errorThrown)
            document.getElementById("message").innerText = "Tài khoản mật khẩu không chính xác"
        }
    })
    event.preventDefault();
}


