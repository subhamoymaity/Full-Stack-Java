// Change this to match your backend protocol (http or https)
const apiUrl = 'http://localhost:8000/api/std/all';

function fetchStdData() {
    fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            // If backend returns { data: [...] }, adjust to data.data
            const students = Array.isArray(data) ? data : data.data;

            const userTableBody = document.querySelector('#userTable tbody');
            userTableBody.innerHTML = ''; // Clear old rows

            students.forEach(student => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.age}</td>
                `;
                userTableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}

window.onload = fetchStdData;
