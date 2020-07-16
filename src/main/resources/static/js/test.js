
$( document ).ready(function() {
    $(function readAll() {

        $.getJSON('/rest', function (data) {
            let html = '<tr>' +
                '<td scope="col" class="label font-weight-bolder ">Id</td>' +
                '<td scope="col" class="label font-weight-bolder label">FirstName</td>' +
                '<td scope="col" class="p5 font-weight-bold">LastName</td>' +
                '<td scope="col" class="p5 font-weight-bold">Age</td>' +
                '<td scope="col" class="p5 font-weight-bold">Email</td>' +
                '<td scope="col" class="p5 font-weight-bold">Role</td>' +
                '<td scope="col" class="p5 font-weight-bold">Edit</td>' +
                '<td scope="col" class="p5 font-weight-bold">Delete</td>' +
                '</tr>';
            for (let i = 0; i < data.length; i++) {
                var user = data[i];
                let func = function (user1) {
                    let arr = [];
                    for (let j = 0; j < user1.role.length; j++) {
                        arr.push(JSON.stringify(user1.role[j].name).replace(/ROLE_/i, ""));
                    }
                    return arr;
                }
                html = html + '<tr><td>' + user.id + '</td>\n' +
                    '        <td id="firstName">' + user.firstName + '</td>\n' +
                    '        <td>' + user.lastName + '</td>\n' +
                    '        <td>' + user.age + '</td>' +
                    '        <td>' + user.email + '</td>' +
                    '        <td>' + func(user) + '</td>' +
                    '        <td><button type="button" class="btn btn-info btn-primary label" data-toggle="modal" data-target="#editModal" value="edit" data-id="' + user.id + '">Edit</button></td>' +
                    '        <td><div th:unless="${#authentication.getName() == ' + user.email + '"><button type="button" class="btn btn-danger btn-primary label" data-toggle="modal" data-target="#deleteModal" value="delete" data-id="' + user.id + '">Delete</button></div></td></tr>';
            }

            console.log(user.email);

            document.getElementById("readTable").innerHTML =  html;
            $('button[value="edit"]').click(function (e) {
                let id =$(this).attr('data-id');
                $.ajax({
                    url:'/rest/'+ id,
                    type: 'GET',
                    dataType:'json',
                    contentType:"application/json; charset=utf-8",
                    success: function (data) {
                        $('[name = "id"]').val(data.id);
                        $('[name = "firstName"]').val(data.firstName);
                        $('[name = "lastName"]').val(data.lastName);
                        $('[name = "age"]').val(data.age);
                        $('[name = "email"]').val(data.email);
                        $('[name = "password"]').val(data.password);
                    }
                })
                $('[name = "editModal"]').modal('show');
                e.preventDefault();
            });
            $('button[value="delete"]').click(function (e) {
                e.preventDefault();
                let id =$(this).attr('data-id');
                $.ajax({
                    url:'/rest/'+ id,
                    type: 'GET',
                    dataType:'json',
                    contentType:"application/json; charset=utf-8",
                    success: function (data) {
                        $('[name = "id"]').val(data.id);
                        $('[name = "firstName"]').val(data.firstName);
                        $('[name = "lastName"]').val(data.lastName);
                        $('[name = "age"]').val(data.age);
                        $('[name = "email"]').val(data.email);
                        $('[name = "password"]').val(data.password);
                        function arrays() {
                            let arr = [];
                            for (let j = 0; j < data.role.length; j++) {
                                arr.push((JSON.stringify(data.role[j].name).replace(/ROLE_/, "")).replace("/\"/g", ""));
                            }
                            return arr;
                        }
                        let html = "";
                        $.each(arrays(), function(key,value) {
                            html = html + '<option>'+value + '</option>';
                        });
                        html = '<select multiple class="form-control form-control-sm" size="2" id="roles">'
                            + html
                            + '</select>';
                        $('select[name="deleteUser"]').replaceWith($(html));
                    }
                })
                $('[name = "deleteModal"]').modal('show');

            });
            $('button[name="submitEdit"]').click(function (e) {
                e.preventDefault();
                let roleName = $('#roleEdit').val();
                let roles1 = [];
                let user = {id: $('input[name="id"]').val(),
                    firstName: $('input[name="firstName"]').val(),
                    lastName: $('input[name="lastName"]').val(),
                    age: $('input[name="age"]').val(),
                    email: $('input[name="email"]').val(),
                    password: $('input[name="password"]').val(),
                    role: getRole(roleName, roles1)};

                $.ajax({
                    type: "PUT",
                    url: '/rest',
                    data: JSON.stringify(user),
                    contentType:"application/json; charset=utf-8",
                    dataType: "json",
                    success: function(){
                        $("#editForm").trigger('reset');
                        $('[name = "editModal"]').modal('hide')
                        readAll();
                    }
                });
            });
            $('button[name="submitDelete"]').click(function (e) {
                e.preventDefault();
                let id = $('[name="id"]').val();
                console.log(id);
                $.ajax({
                    type: "DELETE",
                    url:'/rest/' + id,
                    success: function () {
                        $("#deleteForm").trigger('reset');
                        $('[name = "deleteModal"]').modal('hide')
                        readAll();
                    }
                })

            })

        });

        $('button[name="addUser"]').click(function (e) {
            e.preventDefault();
            let roleName = $('#roleAdd').val();
            let roles1 = [];
            let user = {
                firstName: $('#addForm').find('#firstName').val(),
                lastName: $('#addForm').find('#lastName').val(),
                age: $('#addForm').find('#age').val(),
                email: $('#addForm').find('#email').val(),
                password: $('#addForm').find('#password').val(),
                role: getRole(roleName, roles1)};
            $.ajax({
                type:"POST",
                url:'/rest',
                data: JSON.stringify(user),
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                success: function () {
                    $("#addForm").trigger('reset');
                    readAll()
                    $('[href="#userTable"]').tab('show');
                }

            })
        })



    });
});




function goToSite() {
    window.location.href = "http://localhost:8080/user";
}