import { Link } from "react-router-dom"

const Admin = () => {
  return (
    <section className="container mt-5">
        <h2>Admin Panel</h2>
        <hr/>
        <Link to={"/add"}>Manage Rooms</Link>
    </section>
  )
}

export default Admin