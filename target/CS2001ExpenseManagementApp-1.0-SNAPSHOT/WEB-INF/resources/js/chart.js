/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
function GetMY() {
    var month = document.getElementById("month1").value;
    var year = document.getElementById("year1").value;
    $.ajax({
        url: "http://localhost:8080/CS2001ExpenseManagementApp/api/getMonthYearType/" + month + "/" + year,
        method: "GET",
        success: function (type) {
            $.ajax({
                url: "http://localhost:8080/CS2001ExpenseManagementApp/api/getMonthYearAmount/"+ month + "/" + year,
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

