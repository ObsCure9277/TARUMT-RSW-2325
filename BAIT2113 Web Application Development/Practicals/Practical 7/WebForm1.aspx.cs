using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace P7
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (rblCCType.SelectedValue == "Visa")
            {
                regExCC.ValidationExpression = @"4\d{3}";
            }
            else if(rblCCType.SelectedValue == "Master")
            {
                regExCC.ValidationExpression = @"5\d{3}";
            }
        }
    }
}