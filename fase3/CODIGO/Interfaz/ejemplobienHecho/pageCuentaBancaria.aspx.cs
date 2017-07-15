using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pageCuentaBancaria : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {


        }
        public void limpiarCampos()
        {
            txtNumeroCuenta.Text = "";
            ddlTipoC.ClearSelection();
            txtCuicliente.Text = "";
            txtEmpresa.Text = "";
            txtSaldo.Text = "";
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            try
            {
                if (control.CuentaBancaria(int.Parse(txtNumeroCuenta.Text), int.Parse((ddlTipoC.SelectedValue.ToString())), int.Parse(txtCuicliente.Text), int.Parse(txtEmpresa.Text),double.Parse(txtSaldo.Text)) != null)
                {
                    lblMen.Text = "registro exitoso";
                }
                else
                {
                    lblMen.Text = "llenar los campos correspondientes";
                }
            }catch
            {
                lblMen.Text = "campo no valido ingresado/no llenado";
            }

        }

        protected void btnNuevo_Click(object sender, EventArgs e)
        {
            //ListItem tipo1 = new ListItem("cuenta monetaria", "1");
            //ddlTipoC.Items.Add(tipo1);
            //ListItem tipo2 = new ListItem("cuenta de ahorro", "2");
            //ddlTipoC.Items.Add(tipo2);
            //ListItem tipo3 = new ListItem("cuenta de ahorro a plazo fijo", "3");
            //ddlTipoC.Items.Add(tipo3);
        }

        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                wsBanco.cuentaBancaria cuenta = control.buscarCuentaBancaria(int.Parse(txtBuscar.Text));

                if (control.buscarCuentaBancaria(int.Parse(txtBuscar.Text)) != null)
                {
                    txtNumeroCuenta.Text = cuenta.numeroCuenta.ToString();
                    ddlTipoC.SelectedIndex = ddlTipoC.Items.IndexOf(ddlTipoC.Items.FindByValue(cuenta.idTipoCuenta.ToString()));
                    txtCuicliente.Text = cuenta.numeroCui.ToString();
                    txtEmpresa.Text = cuenta.idClienteEmpresa.ToString();
                    txtSaldo.Text = cuenta.saldo.ToString();
                    lblMen.Text = "Busqueda exitosa";
                }else
                {
                    lblMen.Text = "numero de cuenta del cliente no existe, debe registrarlo";
                }
            }catch
            {
                lblMen.Text = "Debe llenar el campo de busqueda";
            }

        }

        protected void btnElimina_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                if (control.eliminarCuentaBancaria(int.Parse(txtBuscar.Text)) != null)
                {
                    lblMen.Text = "No esta eliminando ningun registro";
                }
                else
                {
                    limpiarCampos();
                    lblMen.Text = "Registsro eliminado";
                }
            }catch
            {
                lblMen.Text = "Debe llenar los campos para eliminar";
            }
            
        }

        protected void btnModifica_Click(object sender, EventArgs e)
        {
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            limpiarCampos();
        }

        protected void btnModifica_Click1(object sender, EventArgs e)
        {
            try
            {
                wsBanco.cuentaBancaria modificar = control.modificarCuentaBancaria(int.Parse(txtNumeroCuenta.Text), int.Parse(ddlTipoC.SelectedValue), int.Parse(txtCuicliente.Text), int.Parse(txtEmpresa.Text),double.Parse(txtSaldo.Text));
                if (control.modificarCuentaBancaria(int.Parse(txtNumeroCuenta.Text), int.Parse(ddlTipoC.SelectedValue), int.Parse(txtCuicliente.Text), int.Parse(txtEmpresa.Text),double.Parse(txtSaldo.Text)) != null)
                {
                    lblMen.Text = "no se pudo modificar";
                }
                else
                {
                    limpiarCampos();
                    lblMen.Text = "modificacion exitosa";
                }
            }
            catch
            {
                lblMen.Text = "algun campo no esta lleno";
            }
        }
    }
}