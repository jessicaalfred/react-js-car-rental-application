import { Col, Form, Input, Row } from "antd";
import AOS from "aos";
import "aos/dist/aos.css"; // You can also use <link> for styles
import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";
import Spinner from "../components/Spinner";
import { userLogin } from "../redux/actions/userActions";
// ..
AOS.init();
function Login() {
  const dispatch = useDispatch();
  const { loading } = useSelector((state) => state.alertsReducer);
  function onFinish(values) {
    dispatch(userLogin(values));
    console.log(values);
  }
  return (
    <div className="login">
      {loading && <Spinner />}
      <Row gutter={16} className="d-flex align-items-center">
        <Col lg={16} style={{ position: "relative" }}>
          <img
            className="w-100"
            data-aos="slide-right"
            data-aos-duration="1500"
            src="https://ik.imagekit.io/tirthashravana/cars/hector-exterior-right-side-view_homkRwb_d.webp?ik-sdk-version=javascript-1.4.3&updatedAt=1658738835642"
          />
          <h1 className="login-logo">BerryRide</h1>
        </Col>
        <Col lg={8} className="text-left p-5">
          <Form
            layout="vertical"
            className="login-form p-5"
            onFinish={onFinish}
          >
            <h1>Login</h1>
            <hr />
            <Form.Item
              name="username"
              label="Username"
              rules={[{ required: true }]}
            >
              <Input />
            </Form.Item>
            <Form.Item
              name="password"
              label="Password"
              rules={[{ required: true }]}
            >
              <Input type="password" />
            </Form.Item>

            <button className="btn1 mt-2">Login</button>

            <hr />

            <Link to="/register">Click Here to Register</Link>
          </Form>
        </Col>
      </Row>
    </div>
  );
}

export default Login;
