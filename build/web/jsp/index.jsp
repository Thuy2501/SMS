<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js" lang="vi">
    <jsp:include page="head.jsp"></jsp:include>

        <body  class="hold-transition skin-blue sidebar-mini" >
            <div class="wrapper">

            <jsp:include page="header.jsp"></jsp:include>
            <jsp:include page="menu.jsp"></jsp:include>
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->


                <!-- Main content -->
                <section class="content">
                    <!-- Small boxes (Stat box) -->
                <jsp:include page="amount.jsp"></jsp:include>

                </section>
                <!-- /.content -->
            </div>
                <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
