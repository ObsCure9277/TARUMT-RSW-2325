<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="HomePage.aspx.cs" Inherits="P5.HomePage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/Registration.aspx">Registration</asp:HyperLink>
            <br />
            <br />
            <asp:HyperLink ID="HyperLink2" runat="server" NavigateUrl="~/LoginPage.aspx">Login</asp:HyperLink>
            <br />
            <br />
            Welcome,
            <asp:LoginName ID="LoginName1" runat="server" />
&nbsp;
            <asp:LoginStatus ID="LoginStatus1" runat="server" />
        </div>
    </form>
</body>
</html>
