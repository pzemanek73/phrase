$(document).ready(function() {
    $("#divProj").text("Loading...");

    $.ajax ({
        url: '/v1/projects',
        datatype: "json",
        success: showData,
        error: showError
    });
});

function showData(data, text) {
    var obj = data; //JSON.parse(data);
    var output = "";
    $.each(obj['content'], function(i, row) {
        var name = row['name'];
        var status = row['status'];
        var sourceLang = row['sourceLang'];
        var targetLangs = row['targetLangs'];
        output+='<li>'+name+', '+status+', '+sourceLang+', ('+targetLangs+')</li>';
    });
    $("#divProj").html(output);
}

function showError(request, status, error) {
    $("#divProj").text("Error: " + request.responseText);
}