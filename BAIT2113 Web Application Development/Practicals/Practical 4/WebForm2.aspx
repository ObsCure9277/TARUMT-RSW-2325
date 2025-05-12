<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm2.aspx.cs" Inherits="P4.WebForm2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:DetailsView ID="DetailsView1" runat="server" AllowPaging="True" AutoGenerateRows="False" DataKeyNames="ProdId" DataSourceID="SqlDataSource1" Height="50px" Width="125px">
                <Fields>
                    <asp:BoundField DataField="ProdId" HeaderText="ProdId" ReadOnly="True" SortExpression="ProdId" />
                    <asp:BoundField DataField="ProdName" HeaderText="ProdName" SortExpression="ProdName" />
                    <asp:BoundField DataField="UnitPrice" HeaderText="UnitPrice" SortExpression="UnitPrice" />
                    <asp:BoundField DataField="Quantity" HeaderText="Quantity" SortExpression="Quantity" />
                    <asp:BoundField DataField="CatID" HeaderText="CatID" SortExpression="CatID" />
                    <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" ShowInsertButton="True" />
                </Fields>
            </asp:DetailsView>
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:ABCConnectionString %>" DeleteCommand="DELETE FROM [Products] WHERE [ProdId] = @ProdId" InsertCommand="INSERT INTO [Products] ([ProdId], [ProdName], [UnitPrice], [Quantity], [CatID]) VALUES (@ProdId, @ProdName, @UnitPrice, @Quantity, @CatID)" SelectCommand="SELECT * FROM [Products]" UpdateCommand="UPDATE [Products] SET [ProdName] = @ProdName, [UnitPrice] = @UnitPrice, [Quantity] = @Quantity, [CatID] = @CatID WHERE [ProdId] = @ProdId">
                <DeleteParameters>
                    <asp:Parameter Name="ProdId" Type="Int32" />
                </DeleteParameters>
                <InsertParameters>
                    <asp:Parameter Name="ProdId" Type="Int32" />
                    <asp:Parameter Name="ProdName" Type="String" />
                    <asp:Parameter Name="UnitPrice" Type="Double" />
                    <asp:Parameter Name="Quantity" Type="Int32" />
                    <asp:Parameter Name="CatID" Type="Int32" />
                </InsertParameters>
                <UpdateParameters>
                    <asp:Parameter Name="ProdName" Type="String" />
                    <asp:Parameter Name="UnitPrice" Type="Double" />
                    <asp:Parameter Name="Quantity" Type="Int32" />
                    <asp:Parameter Name="CatID" Type="Int32" />
                    <asp:Parameter Name="ProdId" Type="Int32" />
                </UpdateParameters>
            </asp:SqlDataSource>
        </div>
    </form>
</body>
</html>
