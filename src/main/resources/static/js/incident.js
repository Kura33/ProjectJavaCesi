$(document).ready(
    function () {
        let $content = $('.content');
        let $table = $('.content table');
        // GET REQUEST
        $(".incidents").click(function (event) {
            event.preventDefault();
            $.ajax({
                type: "GET",
                url: window.location + "/incident/",
                success: function (result) {
                    if (result.status == "success") {
                        $table.empty();
                        var custList = "";
                        $.each(result.data, function (i, incident) {
                            let incidentRef =  "<td>"+incident.getRef()+"</td>";
                            $table.find("tbody tr").append(incidentRef)
                        });
                    } else {
                        $content.html("<strong>Error</strong>");
                    }
                },
                error: function (e) {
                    $content.html("<strong>Error</strong>");
                    console.log("ERROR: ", e);
                }
            });
        });
    });