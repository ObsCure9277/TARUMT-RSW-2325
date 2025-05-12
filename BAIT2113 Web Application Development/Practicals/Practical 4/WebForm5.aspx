<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm5.aspx.cs" Inherits="P4.WebForm5" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 201px;
        }
        .auto-style2 {
            width: 201px;
            height: 23px;
        }
        .auto-style3 {
            height: 23px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <table style="width:100%;">
            <tr>
                <td class="auto-style1">Staff </td>
                <td>&nbsp;</td>
                <td>Year</td>
            </tr>
            <tr>
                <td class="auto-style1">
                    <asp:DropDownList ID="ddlStaff" runat="server" DataSourceID="SqlDataSource1" DataTextField="Name" DataValueField="EmployeeID">
                    </asp:DropDownList>
                    <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:NWConnectionString %>" ProviderName="<%$ ConnectionStrings:NWConnectionString.ProviderName %>" SelectCommand="SELECT LastName + ' ' + FirstName AS Name, EmployeeID FROM Employees"></asp:SqlDataSource>
                </td>
                <td>&nbsp;</td>
                <td>
                    <asp:RadioButtonList ID="rblYear" runat="server" DataSourceID="SqlDataSource2" DataTextField="Y" DataValueField="Y">
                    </asp:RadioButtonList>
                    <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:NWConnectionString %>" SelectCommand="Select Distinct YEAR(Orderdate) as Y from Orders"></asp:SqlDataSource>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">&nbsp;</td>
                <td>&nbsp;</td>
                <td>
                    <asp:Button ID="btnSearch" runat="server" Text="Search" />
                </td>
            </tr>
            <tr>
                <td class="auto-style2">
                    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True" AutoGenerateColumns="False" DataKeyNames="OrderID" DataSourceID="SqlDataSource3">
                        <Columns>
                            <asp:CommandField ShowSelectButton="True" />
                            <asp:BoundField DataField="OrderID" HeaderText="OrderID" InsertVisible="False" ReadOnly="True" SortExpression="OrderID" />
                            <asp:BoundField DataField="OrderDate" HeaderText="OrderDate" SortExpression="OrderDate" />
                        </Columns>
                    </asp:GridView>
                    <asp:SqlDataSource ID="SqlDataSource3" runat="server" ConnectionString="<%$ ConnectionStrings:NWConnectionString %>" SelectCommand="Select OrderID, OrderDate from Orders
where EmployeeID=@ID and YEAR(OrderDate) =@Y;">
                        <SelectParameters>
                            <asp:ControlParameter ControlID="ddlStaff" Name="ID" PropertyName="SelectedValue" />
                            <asp:ControlParameter ControlID="rblYear" Name="Y" PropertyName="SelectedValue" />
                        </SelectParameters>
                    </asp:SqlDataSource>
                </td>
                <td class="auto-style3"></td>
                <td class="auto-style3">
                    <asp:Repeater ID="Repeater1" runat="server" DataSourceID="SqlDataSource4">
                    <ItemTemplate>
                        Product Name : <%#Eval("ProductName") %>
                        <br />
                        Unit Price: <%#Eval("UnitPrice", "{0:C2}") %>
                        <br />
                        Sales : <%#Eval("Sales", "{0:C2}") %>
                        <br />
                        <br />
                    </ItemTemplate>
                    
                    </asp:Repeater>
                    <asp:SqlDataSource ID="SqlDataSource4" runat="server" ConnectionString="<%$ ConnectionStrings:NWConnectionString %>" SelectCommand="select Products.ProductName, [Order Details].UnitPrice,
[Order Details].Quantity, [Order Details].Discount,
([Order Details].UnitPrice * [Order Details].Quantity * (1-[Order Details].Discount)) as Sales
from [Order Details] inner join Products
on [Order Details].ProductID = Products.ProductID
inner join Orders
on [Order Details].OrderID = Orders.OrderID
Where Orders.OrderID=@ID
">
                        <SelectParameters>
                            <asp:ControlParameter ControlID="GridView1" Name="ID" PropertyName="SelectedValue" />
                        </SelectParameters>
                    </asp:SqlDataSource>
                </td>
            </tr>
            <tr>
                <td class="auto-style2"></td>
                <td class="auto-style3"></td>
                <td class="auto-style3"></td>
            </tr>
            <tr>
                <td class="auto-style1">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style1">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style1">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
        <div>
        </div>
    </form>
</body>
</html>
