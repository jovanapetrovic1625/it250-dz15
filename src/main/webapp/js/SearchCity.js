$(document).ready(function () {
    $("#pretraga").keyup(function () {
        var value = $(this).val();
        if (value != "")
            $.ajax({
                url: 'services/FindCity?name=' + value,
                data: {
                    name: value
                },
                success: function (data) {
                    $('#info').empty();
                    $('#info').append(data);
                }
            });
    });
});