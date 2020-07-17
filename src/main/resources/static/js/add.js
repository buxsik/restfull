function getAdd() {
    $("#addForm").trigger('reset');
    var roleData = $(getRoleList())
    let roleList = "";
    for (let i =0; i < roleData.length; i++) {
        let name = JSON.stringify(roleData[i].name).replace(/ROLE_/i, "");
        roleList = roleList + '<option value="' + roleData[i].id + '">' + name + '</option>';
    }
    roleList = '<select multiple class="form-control form-control-sm" size="2"  id="roleAdd">'
        + roleList
        + '</select>';
    $('select[name="role"]').replaceWith(roleList);
}