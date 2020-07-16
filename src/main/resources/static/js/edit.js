


function getRole(roleName,roles1) {
    if (roleName.length != 1) {
        for (let i = 0; i < roleName.length; i++) {
            let j = i + 1;
            let roles = {
                id: j,
                name: roleName[i]
            }

            roles1.push(roles)
        }
        return roles1;
    } else {
        if(roleName[0] == "ADMIN") {
            let roles = {
                id: 1,
                name: "ROLE_ADMIN"
            }

            roles1.push(roles)
            return roles1;
        } else {
            let roles = {
                id: 2,
                name: "ROLE_USER"
            }

            roles1.push(roles)
            return roles1;
        }
    }
}