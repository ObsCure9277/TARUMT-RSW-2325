using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Security;
namespace P5
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnGetUsers_Click(object sender, EventArgs e)
        {
            ddlUsers.DataSource = Membership.GetAllUsers();
            ddlUsers.DataBind();
        }

        protected void btnCreateRole_Click(object sender, EventArgs e)
        {
            Roles.CreateRole(txtRole.Text);
        }

        protected void btnGetRoles_Click(object sender, EventArgs e)
        {
            ddlRoles.DataSource = Roles.GetAllRoles();
            ddlRoles.DataBind();
        }

        protected void btnAssign_Click(object sender, EventArgs e)
        {
            Roles.AddUserToRole(ddlUsers.SelectedValue, ddlRoles.SelectedValue);
        }

        protected void btnVerify_Click(object sender, EventArgs e)
        {
            lstUsers.DataSource = Roles.GetUsersInRole(ddlRoles.SelectedValue);
            lstUsers.DataBind();
        }
    }
}