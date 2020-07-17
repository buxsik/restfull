function getRoleList() {
    var roleData = {};
    $.ajax({
        url: "roleApi",
        async: false,
        dataType: 'json',
        success: function(data) {
            roleData = data;
        }

    });
    return roleData;

}


