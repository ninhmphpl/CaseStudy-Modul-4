let id
function getidlocal(){
id =   localStorage.getItem("idOffer")
    return id;
}
function offerByID(id) {
    let content = ""
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/admOffer"+id,
        success: function (data) {


        }

    })
}