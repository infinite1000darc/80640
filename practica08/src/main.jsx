import React from 'react'
import ReactDOM from 'react-dom/client'
//import App from './App.jsx'
import './index.css'
import MiFieldSet from './MiFieldSet.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/*<App />*/}
    <MiFieldSet titulo="Datos Personales" texto1="nombre" texto2="contraseña"></MiFieldSet>
  </React.StrictMode>,
)
