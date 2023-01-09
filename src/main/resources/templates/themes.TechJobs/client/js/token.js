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
        return ""
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
        pageBefore = "/web/web.main/templates/themes.TechJobs/client/offer.html"
    }
    window.location = pageBefore
}
// tự động gán url doing(tham số truyền vào là những trang ngoại lệ không gán)
function autoSetURLDoing(){
    pageBefore = sessionStorage.getItem("doing")
    if (pageBefore === window.location.href){
        pageBefore = "/web/web.main/templates/themes.TechJobs/client/offer.html"
    }
    sessionStorage.setItem("doing", window.location.href)
}
// ẩn thẻ theo id
function hide(id){
    if(!document.getElementById(id).hidden){
    document.getElementById(id).hidden = true
    }
}
// hiện thẻ theo id
function show(id){
    if(!document.getElementById(id).hidden){
        document.getElementById(id).hidden = false
    }
}
//setInnerHTMLById , gán hiển thị của the theo id
function setInnerHTMLById(id, value){
    document.getElementById(id).innerHTML = value
}
function getValueById(id){
    return document.getElementById(id).value
}
// đăng xuất khỏi tài khoản
function logOut(){
    sessionStorage.clear()
    window.location = "/web/web.main/templates/themes.TechJobs/client/offer.html"
    event.preventDefault();
}
autoSetURLDoing()
