$( document ).ready( function () {
    $(function () {
        $.getJSON('/userApi', function (data) {

            let html = '<tr >' +
                '<td class="label font-weight-bolder mb-5 tabUser">About user</td>' +
                '</tr>' +
                '<tr>' +
                '<td scope="col" class="label font-weight-bolder ">Id</td>' +
                '<td scope="col" class="label font-weight-bolder label">FirstName</td>' +
                '<td scope="col" class="p5 font-weight-bold">LastName</td>' +
                '<td scope="col" class="p5 font-weight-bold">Age</td>' +
                '<td scope="col" class="p5 font-weight-bold">Email</td>' +
                '<td scope="col" class="p5 font-weight-bold">Role</td>' +
                '</tr>';

            let user = data;
            let func = function (user1) {
                let arr = [];
                for (let j = 0; j < user1.role.length; j++) {
                    arr.push(JSON.stringify(user1.role[j].name).replace(/ROLE_/i, ""));
                }
                return arr;
            }
            html = html + '<tr><td>' + user.id + '</td>\n' +
               '        <td>' + user.firstName + '</td>\n' +
               '        <td>' + user.lastName + '</td>\n' +
               '        <td>' + user.age + '</td>' +
               '        <td>' + user.email + '</td>' +
               '        <td>' + func(user) + '</td>' +
               '        </tr>';
            document.getElementById("userTable").innerHTML =  html;
        })
    })

})