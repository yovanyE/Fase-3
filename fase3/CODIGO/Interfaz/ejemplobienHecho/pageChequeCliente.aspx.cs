using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pageChequeCliente : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public void limpiarCampos()
        {
            txtDescripcion.Text = "";
            txtCantidadPago.Text = "";
            txtFechaPAGO.Text = "";
            txtNumeroC.Text = "";
        }
        protected void btnBuscar_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                wsBanco.cheque chequera = control.buscarCheque(int.Parse(txtBuscar.Text));

                if (control.buscarCheque(int.Parse(txtBuscar.Text)) != null)
                {
                    txtDescripcion.Text = chequera.descripcion;
                    txtCantidadPago.Text = chequera.cantidad.ToString();
                    txtFechaPAGO.Text = chequera.fechaPago;
                    txtNumeroC.Text = chequera.numeroCuenta.ToString();
                    lblMen.Text = "busqueda exitosa";
                }
                else
                {
                    lblMen.Text = "numero Cuenta del cliente no existe, desea registrarlo?";
                }
            }
            catch
            {
                lblMen.Text = "Debe llenar el campo de busqueda";
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            try
            {
                if (control.registrarCheque(txtDescripcion.Text, Double.Parse(txtCantidadPago.Text), txtFechaPAGO.Text, int.Parse(txtNumeroC.Text)) != null)
                {
                    lblMen.Text = "registro exitoso";
                    limpiarCampos();
                }
                else
                {
                    lblMen.Text = "Debe llenar todos los campos";
                }
            }
            catch
            {
                lblMen.Text = "campo no valido";
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            try
            {
                wsBanco.cheque modifiacr = control.modificarCheque(txtDescripcion.Text, Double.Parse(txtCantidadPago.Text), txtFechaPAGO.Text, int.Parse(txtNumeroC.Text));
                if (control.modificarCheque(txtDescripcion.Text, Double.Parse(txtCantidadPago.Text), txtFechaPAGO.Text, int.Parse(txtNumeroC.Text)) != null)
                {
                    lblMen.Text = "Debe llenar todos los campos para modificar";
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

        protected void btnElimina_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                if (control.eliminarCheque(int.Parse(txtBuscar.Text)) != null)
                {
                    lblMen.Text = "DEBE LLENAR EL CAMPO DE BUSQUEDA";
                }
                else
                {
                    lblMen.Text = "REGISTRO ELIMINADO";
                    limpiarCampos();
                }
            }
            catch
            {
                lblMen.Text = "DEBE LLENAR EL CAMPO DE BUSQUEDA";
            }
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            limpiarCampos();
        }
    }
}