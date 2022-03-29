<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }

        .table-responsive {
            margin: 30px 0;
        }

        .table-wrapper {
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            min-width: 1000px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 15px;
            background: #435d7d;
            color: #fff;
            padding: 16px 30px;
            min-width: 100%;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }

        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }

        .table-title .btn-group {
            float: right;
        }

        .table-title .btn {
            color: #fff;
            float: right;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }

        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }

        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }

        table.table tr th:first-child {
            width: 60px;
        }

        table.table tr th:last-child {
            width: 100px;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }

        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }

        table.table td a:hover {
            color: #2196F3;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #F44336;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }

        .pagination {
            float: right;
            margin: 0 0 5px;
        }

        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }

        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }

        /* Custom checkbox */
        .custom-checkbox {
            position: relative;
        }

        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            position: absolute;
            margin: 5px 0 0 3px;
            z-index: 9;
        }

        .custom-checkbox label:before {
            width: 18px;
            height: 18px;
        }

        .custom-checkbox label:before {
            content: '';
            margin-right: 10px;
            display: inline-block;
            vertical-align: text-top;
            background: white;
            border: 1px solid #bbb;
            border-radius: 2px;
            box-sizing: border-box;
            z-index: 2;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            content: '';
            position: absolute;
            left: 6px;
            top: 3px;
            width: 6px;
            height: 11px;
            border: solid #000;
            border-width: 0 3px 3px 0;
            transform: inherit;
            z-index: 3;
            transform: rotateZ(45deg);
        }

        .custom-checkbox input[type="checkbox"]:checked + label:before {
            border-color: #03A9F4;
            background: #03A9F4;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            border-color: #fff;
        }

        .custom-checkbox input[type="checkbox"]:disabled + label:before {
            color: #b8b8b8;
            cursor: auto;
            box-shadow: none;
            background: #ddd;
        }

        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }

        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }

        .modal .modal-content {
            border-radius: 3px;
            font-size: 14px;
        }

        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }

        .modal .modal-title {
            display: inline-block;
        }

        .modal .form-control {
            border-radius: 2px;
            box-shadow: none;
            border-color: #dddddd;
        }

        .modal textarea.form-control {
            resize: vertical;
        }

        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }

        .modal form label {
            font-weight: normal;
        }

        .filter-icon {
            float: right;
            margin-top: 7px;
        }

        .filter-icon i {
            font-size: 18px;
            opacity: 0.7;
        }

        .table-filter .filter-group {
            float: right;
            margin-left: 15px;
        }

        .table-filter input, .table-filter select {
            height: 34px;
            border-radius: 3px;
            border-color: #ddd;
            box-shadow: none;
        }

        .table-filter {
            padding: 5px 0 15px;
            border-bottom: 1px solid #e9e9e9;
            margin-bottom: 5px;
        }

        .table-filter .btn {
            height: 34px;
        }

        .table-filter label {
            font-weight: normal;
            margin-left: 10px;
        }

        .table-filter select, .table-filter input {
            display: inline-block;
            margin-left: 5px;
        }

        .table-filter input {
            width: 200px;
            display: inline-block;
        }

        .show-entries select.form-control {
            width: 60px;
            margin: 0 5px;
        }

        .show-entries select.form-control {
            width: 60px;
            margin: 0 5px;
        }

        .filter-group select.form-control {
            width: 110px;
        }

        .table-filter .filter-group {
            float: right;
            margin-left: 15px;
        }

        .filter-group select.form-control {
            width: 110px;
        }

    </style>
    <script>
        $(document).ready(function () {
            // Activate tooltip
            $('[data-toggle="tooltip"]').tooltip();

            // Select/Deselect checkboxes
            var checkbox = $('table tbody input[type="checkbox"]');
            $("#selectAll").click(function () {
                if (this.checked) {
                    checkbox.each(function () {
                        this.checked = true;
                    });
                } else {
                    checkbox.each(function () {
                        this.checked = false;
                    });
                }
            });
            checkbox.click(function () {
                if (!this.checked) {
                    $("#selectAll").prop("checked", false);
                }
            });
        });
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">

                <!--        HEADER-->
                <div class="row">
                    <div class="col-sm-10 text-center">
                        <h2>Quản lý <b>Bệnh Án</b></h2>
                    </div>

                    <%--                    CREATE--%>
                    <div class="col-sm-2">
                        <a href="/benhAn?action=create" class="btn btn-success"><i
                                class="material-icons">&#xE147;</i> <span>Tạo mới Bệnh Án</span></a>
                    </div>
                </div>
            </div>
            <div class="table-filter">
                <div class="row">

                    <!--          SORT-->
                    <div class="col-sm-3">
                        <%--                        FORM SORT--%>
                        <form method="get" id="sortForm" onchange="submitSortForm()">
                            <div class="filter-group">
                                <select name="action" id="sort" class="form-control">
                                    <option value="default" selected>Sắp xếp</option>
                                    <option value="sortByMaBenhAn">Sắp xếp theo mã bênh án</option>
                                    <option value="sortByTenBenhNhan">Sắp xếp theo tên bệnh nhân</option>
                                </select>
                            </div>
                        </form>
                    </div>

                    <!--          SEARCH-->
                    <div class="col-sm-9">
                        <div class="filter-group">
                            <div class="filter-group d-flex">

                                <%--                                REFRESH BUTTON--%>
                                <span class="input-group-text" id="basic-addon1"
                                      style="width: fit-content;padding-bottom: 0px;">
                                      <a href="/benhAn?action=list" type="button"><svg
                                              xmlns="http://www.w3.org/2000/svg" width="16"
                                              height="16"
                                              fill="currentColor"
                                              class="bi bi-arrow-clockwise" viewBox="0 0 16 16"
                                              style="margin-bottom: 6px;">
                                          <path fill-rule="evenodd"
                                                d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"></path>
                                          <path
                                                  d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"></path>
                                      </svg></a>
                                    </span>

                                <%--                                SEARCH--%>
                                <form method="get">
                                    <input type="hidden" name="action" value="search">
                                    <input type="text" class="form-control" placeholder="Tên Bệnh nhân"
                                           aria-label="Input group example" aria-describedby="basic-addon1"
                                           name="tenBenhNhanSearch">
                                    <input type="text" class="form-control" placeholder="Mã Bệnh án"
                                           aria-label="Input group example" aria-describedby="basic-addon1"
                                           name="maBenhAnSearch">
                                    <button type="submit" class="btn btn-primary" style="margin-left: 10px;"><i
                                            class="fa fa-search"></i></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã bệnh án</th>
                    <th>Mã bệnh nhân</th>
                    <th>Tên bệnh nhân</th>
                    <th>Ngày nhập viện</th>
                    <th>Ngày ra viện</th>
                    <th>Lý do nhập viện</th>
                    <th>Tác vụ</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${benhAnDTOList}" var="benhAnDTO" varStatus="count">
                    <tr>
                        <td>${count.index+1}</td>
                        <td>${benhAnDTO.maBenhAn}</td>
                        <td>${benhAnDTO.maBenhNhan}</td>
                        <td>${benhAnDTO.tenBenhNhan}</td>
                        <td>${benhAnDTO.ngayNhapVien}</td>
                        <td>${benhAnDTO.ngayRaVien}</td>
                        <td>${benhAnDTO.lyDo}</td>
                        <td colspan="2">
                            <a href="/benhAn?action=update&maBenhAn=${benhAnDTO.maBenhAn}" class="update"><i
                                    class="material-icons"
                                    data-toggle="tooltip"
                                    title="Update">&#xE254;</i></a>


                                <%--                            Chú ý phải bọc trong dấu '' cho tham số truyền xuống JS--%>
                            <a href="#deleteModal" class="delete" data-toggle="modal"
                               onclick="getIdDelete('${benhAnDTO.maBenhAn}')"><i class="material-icons"
                                                                                 data-toggle="tooltip"
                                                                                 title="Delete">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

            <!--      PAGINATION-->
            <div class="clearfix">
                <ul class="pagination">
                    <li class="page-item disabled"><a href="product?index=${index-1}">Previous</a></li>
                    <c:forEach begin="1" end="${endPageNumber}" var="numberPage">
                        <li class="page-item"><a href="/benhAn?action=sortByMaBenhAn&numberPage=${numberPage}" class="page-link">${numberPage}</a></li>
                    </c:forEach>
                    <li class="page-item"><a href="product?index=${index+1}" class="page-link">Next</a></li>
                </ul>
            </div>

            <p>${messageCreate}</p>
        </div>
    </div>
</div>

<!--MODAL DELETE-->
<div id="deleteModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/benhAn?action=delete">
                <input type="hidden" name="maBenhAnDelete" id="maBenhAnDelete">
                <div class="modal-header">
                    <h4 class="modal-title">Xóa</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p id="message">Bạn có xác nhận muốn xóa?</p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy">
                    <input type="submit" class="btn btn-danger" value="Xác nhận">
                </div>
            </form>
        </div>
    </div>
</div>


</body>


<script>
    function getIdDelete(maBenhAnDelete) {
        document.getElementById("maBenhAnDelete").value = maBenhAnDelete;
        console.log(maBenhAnDelete);
        // $(document).ready(function(){
        // $("#message").text("Bạn có xác nhận xóa bệnh án có mã bệnh án là " + id + " không?");
        // });
        // document.getElementById("message").innerText = "Bạn có xác nhận xóa bệnh án có mã bệnh án là " + id + " không?";
    }

    function getIdUpdate(id) {
        document.getElementById("idGetUpdate").value = id;
    }

    function submitSortForm() {
        document.getElementById("sortForm").submit();
    }

</script>
</html>
