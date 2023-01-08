let pageBefore

let token = JSON.parse(sessionStorage.getItem("token"))
// gán lại url trang hiện tại
function setDoingURL() {
    sessionStorage.setItem("doing", window.location.href)
}
// lấy url trang hiện tại
function getDoingUrl() {
    let url = sessionStorage.getItem("doing")
    if (url == null) {
        url = "/web/web.main/templates/themes.TechJobs/client/index.html"
    }
    return url
}
// gán lại token
function setToken(token) {
    sessionStorage.setItem("token", JSON.stringify(token))
    console.log("Token set OK: " + getToken())
}
// lấy token
function getToken() {
    if (token == null) {
        console.log("Token null")
        return "Null"
    }
    console.log("Token OK:" + token.token)
    return token.type + token.token
}
// lấy email của user
function getEmailAccount() {
    if (token == null) {
        return "Null"
    }
    return token.email
}
// lấy quyền của user
function getRole() {
    if (token == null) {
        return "Null"
    }
    return token.role
}
// lấy id của user
function getId() {
    if (token == null) return -1
    return token.id
}
// trở lại trang trước khi đăng nhập
function backPage(){
    if(pageBefore == null){
        pageBefore = "/web/web.main/templates/themes.TechJobs/client/index.html"
    }
    window.location = pageBefore
}
// tự động gán url doing(tham số truyền vào là những trang ngoại lệ không gán)
function autoSetURLDoing(){
    pageBefore = sessionStorage.getItem("doing")
    if (pageBefore === window.location.href){
        pageBefore = "/web/web.main/templates/themes.TechJobs/client/index.html"
    }
    sessionStorage.setItem("doing", window.location.href)
}
autoSetURLDoing()