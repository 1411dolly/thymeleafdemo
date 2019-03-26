$(document).on('click', '#populateUsersId', function () {
    populateUsers();
});
var populateUsers = function () {
    var users = $.ajax({
        url: "/usersAjax",
        method: "GET"
    });
    users.done(function (data) {
        if (data) {
            data.forEach(function (user) {
                $('#userUlId').append("<li>" + user.firstName + "</li>");
            });
        }
    });
    users.fail(function (jqXHR, textStatus) {
        console.log("Error in fetching users");
    })
};

