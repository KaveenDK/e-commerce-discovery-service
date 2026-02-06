const express = require('express');
const {Eureka} = require('eureka-js-client');


const app = express();
const port = 3000;  // The port the service is running on


const router = express.Router()
// Item route
router.get('/items', (req, res) => {
    res.json({
        items: ['Milk', 'Eggs', 'Bread'],
        message: 'Welcome to the Item Service',
    });
});


app.use('/item-service', router)


// Eureka Client Configuration
const eurekaClient = new Eureka({
    instance: {
        instanceId: "item-service",
        app: "ITEM-SERVICE",
        hostName: "localhost",
        ipAddr: "127.0.0.1",
        port: {
            $: port,              "@enabled": true,
        },
        vipAddress: "item-service",
        dataCenterInfo: {
            "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
            name: "MyOwn",
        },
    },
    eureka: {
        host: "localhost",
        port: 8761,
        servicePath: "/eureka/apps/",
    },
});


// Start the Express Server
app.listen(port, () => {
    console.log(`✅ Item service running at http://localhost:${port}`);


    // Register with Eureka
    eurekaClient.start((error) => {
        if (error) {
            console.error('❌ Failed to register with Eureka:', error);
        } else {
            console.log('✅ Successfully registered with Eureka.');
        }
    });
});
