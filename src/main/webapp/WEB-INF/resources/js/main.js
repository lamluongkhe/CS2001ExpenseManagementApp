function deleteTrans(path) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Something wrong!!!");
        });
    }
}
function getMonth() {
    var month = document.getElementById("month").value;
    $.ajax({
        url: "http://localhost:8080/CS2001ExpenseManagementApp/api/getMonthType/" + month,
        method: "GET",
        success: function (type) {
            $.ajax({
                url: "http://localhost:8080/CS2001ExpenseManagementApp/api/getMonthAmount/" + month,
                method: "GET",
                success: function (amount) {
                    del = new Chart(ctx, {
                        type: 'bar',
                        data: {
                            labels: type,
                            datasets: [{
                                    label: 'Stats Amount',
                                    data: amount,
                                    borderWidth: 1
                                }]
                        },
                        options: {
                            scales: {
                                y: {
                                    beginAtZero: true
                                }
                            }
                        }
                    });
                }
            });
        }
    });
    const ctx = document.getElementById('myChart');
}

function getYear() {
    var year = document.getElementById("year").value;
    $.ajax({
        url: "http://localhost:8080/CS2001ExpenseManagementApp/api/getYearType/" + year,
        method: "GET",
        success: function (type) {
            $.ajax({
                url: "http://localhost:8080/CS2001ExpenseManagementApp/api/getYearAmount/" + year,
                method: "GET",
                success: function (amount) {
                    del = new Chart(ctx, {
                        type: 'bar',
                        data: {
                            labels: type,
                            datasets: [{
                                    label: 'Stats Amount',
                                    data: amount,
                                    borderWidth: 1
                                }]
                        },
                        options: {
                            scales: {
                                y: {
                                    beginAtZero: true
                                }
                            }
                        }
                    });
                }
            });
        }
    });
    const ctx = document.getElementById('myChart');
}


function deleteChart() {
    del.destroy();
}



