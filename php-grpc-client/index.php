<?php
// Autoload files using the Composer autoloader.
require_once __DIR__ . '/vendor/autoload.php';

use Com\Migration\Poc\JavaRestGrpcServerServiceClient;
use Com\Migration\Poc\JavaRestGrpcServerRequest;

function callGrpcClient($hostname, $name)
{
    $client = new JavaRestGrpcServerServiceClient($hostname, [
        'credentials' => Grpc\ChannelCredentials::createInsecure(),
    ]);
    $request = new JavaRestGrpcServerRequest();
    $request->setName($name);
    list($response, $status) = $client->send($request)->wait();
    if ($status->code !== Grpc\STATUS_OK) {
        echo "ERROR: " . $status->code . ", " . $status->details . PHP_EOL;
        exit(1);
    }
    echo $response->getMessage() . PHP_EOL;
    echo("Done");
}

callGrpcClient('localhost:6004', ' André php');