async function getData() {
    try {
        const response = await fetch('/api/person/all');
        const data = await response.json();

        await allUser(data);

    } catch (error) {
        console.error(error);
    }
}
async function allUser(users) {
    const el = document.getElementById('users');
    let st = "";
    for (let i = 0; i <= users.length - 1; i++) {
        const deleteButtonId = `deleteButton${users[i].id}`;
        const editButtonId = `editButton${users[i].id}`;
        st += `
      <tr>
        <td>${users[i].id}</td>
        <td>${users[i].password}</td>
        <td>${users[i].username}</td>
        <td>
          <button id="${editButtonId}" type="button" class="btn btn-sm btn-primary" data-bs-toggle="modal" onclick="usersHtmlPut('${users[i].name}', '${users[i].username}', '${users[i].age}', '${users[i].email}', '${users[i].pass}'); editeUsersPutServer('${users[i].id}')">Edit</button>
        </td>
        <td>
          <button id="${deleteButtonId}" type="button" class="btn btn-sm btn-danger" onclick="usersHtml('${users[i].id}', '${users[i].name}', '${users[i].username}', '${users[i].age}', '${users[i].email}'); deleteStatus('${users[i].id}')">Delete</button>
        </td>
      </tr>`;
    }
    el.innerHTML = st;
}
document.addEventListener("DOMContentLoaded", getData);