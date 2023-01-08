// phoneNumber
// password
// repassword
// email
// fullName
// typeAcount

//formCreate
// private String email;
// private String password;
// private Long role;
// private String phoneNumber;
// private String name;
function printNull(idOut, idIn) {
    let string = document.getElementById(idIn).value
    if (!string) {
        document.getElementById(idOut).innerHTML = "Không được để trống <br>"
        return true
    }
    document.getElementById(idOut).innerHTML = ""
    return false
}

function signIn() {
    let flag = false
    let phoneNumber = document.getElementById("phoneNumber").value
    let email = document.getElementById("email").value
    let fullName = document.getElementById("fullName").value
    let password = document.getElementById("password").value
    let rePassword = document.getElementById("rePassword").value
    let role = +document.getElementById("typeAccount").value
    if (password !== rePassword) {
        document.getElementById("messagePassword").innerText = "Mật khẩu không trùng khớp"
        flag = true
    }

    if (printNull("massagePhone","phoneNumber")) {
        flag = true
    }
    if (printNull("messageEmail","email")) {
        flag = true
    }
    if (printNull("messageName", "fullName")) {
        flag = true
    }
    if (printNull("messagePassword1","password")) {
        flag = true
    }
    if (printNull("messagePassword2","rePassword")) {
        flag = true
    }
    if(flag)return;


    let user = {
        email: email,
        password: password,
        role: role,
        phoneNumber: phoneNumber,
        name: fullName
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: "POST",
        url: "http://localhost:8080/api/singIn",
        data: JSON.stringify(user),
        success: function (data) {
            let content = "Đăng kí thành công"
            if (role === 3) {
                content += ", Vui lòng chờ admin xét duyệt để sử dụng tài khoản."
            }
            document.getElementById("messagePassword").innerText = content
        },
        error: function (jqXHR, textStatus, errorThrown){
            //415 tài khoản tồn tại
            let content = "Đăng ký không thành công"
            console.log(jqXHR.status)
            if (jqXHR.status === 415) {
                content += ", Tài khoản này đã tồn tại"
            }
            document.getElementById("messagePassword").innerText = content
        }
    })


}