// // lấy object token về js
// let data = sessionStorage.getItem("token")
// // lấy mã token từ data
// let token = data.token
// // lấy email của user đăng nhập
// let name = data.name


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
            'Content-Type': 'application/json',
            // 'Authorization' : token
        },
        type: "POST",
        url: "http://localhost:8081/api/login",
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
sessionStorage.setItem("doing", "http://localhost:63342/CaseStudy_Modul4/web.main/templates/themes.TechJobs/client/offer.html")