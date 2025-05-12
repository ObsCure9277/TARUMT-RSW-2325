<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm3.aspx.cs" Inherits="P4.WebForm3" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            Category :
            <asp:DropDownList ID="ddlCategory" runat="server" DataSourceID="SqlDataSource1" DataTextField="CategoryName" DataValueField="CategoryId" AutoPostBack="True">
            </asp:DropDownList>
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:ABCConnectionString %>" SelectCommand="SELECT * FROM [Categories]"></asp:SqlDataSource>
            <br />
            <br />
            <br />
            <asp:Repeater ID="Repeater1" runat="server" DataSourceID="SqlDataSource2">

                <ItemTemplate>
                    Product Name: <%#Eval("ProdName") %>
                    <br />
                    Unit Price :  <%#Eval("UnitPrice") %>
                    <br />
                    <br />
                </ItemTemplate>

            </asp:Repeater>
            <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:ABCConnectionString %>" SelectCommand="SELECT * FROM [Products] WHERE ([CatID] = @CatID)">
                <SelectParameters>
                    <asp:ControlParameter ControlID="ddlCategory" Name="CatID" PropertyName="SelectedValue" Type="Int32" />
                </SelectParameters>
            </asp:SqlDataSource>
            <br />
        </div>
    </form>
</body>
</html>
