using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pageCanjeaProducto : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public void limpiarCampos()
        {
            txtCuenta.Text = "";
            ddlProducto.ClearSelection();
        }

        protected void btnBuscar_Click(object sender, ImageClickEventArgs e)
        {
            wsBanco.cuentaBancaria cuenta = control.buscarCuentaBancaria(int.Parse(txtBuscar.Text));
            if (cuenta.saldo>=100 && cuenta.saldo<=2500)
            {
                txtCuenta.Text = cuenta.numeroCuenta.ToString();
                ddlProducto.ClearSelection();
                ListItem tipoCuenta = new ListItem("tarjeta Deebito", "1");
                ddlProducto.Items.Add(tipoCuenta);

            }
            else if (cuenta.saldo >= 3000)
            {
                txtCuenta.Text = cuenta.numeroCuenta.ToString();
                ddlProducto.ClearSelection();
                ListItem tipoCuenta2 = new ListItem("celular", "2");
                ddlProducto.Items.Add(tipoCuenta2);
            }
        }

        protected void btnReporte_Click(object sender, ImageClickEventArgs e)
        {

        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            try
            {
               if(control.registrarOrdenProducto(int.Parse(ddlProducto.SelectedValue.ToString()), int.Parse(txtCuenta.Text))!=null){
                    limpiarCampos();
                    lblMen.Text = "registrado exitosamente";
                }
                else
                {
                    lblMen.Text = "Debe llenar todos los campos";
                }

            }
            catch
            {
                lblMen.Text = "tipo de dato incorrecto ingresado";
            }
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            limpiarCampos();

        }
    }
}