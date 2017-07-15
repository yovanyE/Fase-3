<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="pageLogin.aspx.cs" Inherits="ejemplobienHecho.page1Cargable" %>

<!DOCTYPE html>

<html class="bg-black" xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Sistema nuevo</title>
    <link href="//max.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="//cdnjs.CluodFlare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />

</head>
<body class="bg-black">
    <div class="form-box" id="login-box"> 
         <div class="header">iniciar Sesion</div>
    <form id="form1" runat="server">
    <div class="body bg-gray">
    <div class="form-group" style="width: 321px; height: 146px">
        <asp:TextBox ID="txtUsuario" runat="server" CssClass="form-control" placeholder="Ingrese usuario" Width="295px"></asp:TextBox>
        <br />
        <br />
        <div class="form-group">
            <asp:TextBox ID="txtPass" runat="server" CssClass="form-control" placeHolder="Ingrese su password" Width="294px"></asp:TextBox>
            <br />
        </div>
          <div class="footer" style="width: 261px">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <asp:Button ID="btnIngresar" runat="server" Text="iniciar Sesion" CssClass="btn bg-olive btn-xs" OnClick="btnIngresar_Click" />
            </div>
         <div class="footer" style="width: 261px">
                <asp:Label ID="lblMensaje" runat="server" CssClass="btn btn-danger" ></asp:Label>
            </div>
    </div>
    </div>
    </form>
         </div>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script scr="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
