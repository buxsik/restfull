function getRole(roleId, roleName,roles1) {

        console.log(roleName);
        for (let i = 0; i < roleId.length; i++) {

            let roles = {
                id: roleId[i],
                name: roleName[i]
            }

            roles1.push(roles);
        }
        return roles1;
}
