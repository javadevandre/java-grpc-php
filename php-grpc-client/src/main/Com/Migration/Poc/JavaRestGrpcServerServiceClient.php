<?php
// GENERATED CODE -- DO NOT EDIT!

namespace Com\Migration\Poc;

/**
 */
class JavaRestGrpcServerServiceClient extends \Grpc\BaseStub {

    /**
     * @param string $hostname hostname
     * @param array $opts channel options
     * @param \Grpc\Channel $channel (optional) re-use channel object
     */
    public function __construct($hostname, $opts, $channel = null) {
        parent::__construct($hostname, $opts, $channel);
    }

    /**
     * @param \Com\Migration\Poc\JavaRestGrpcServerRequest $argument input argument
     * @param array $metadata metadata
     * @param array $options call options
     * @return \Grpc\UnaryCall
     */
    public function send(\Com\Migration\Poc\JavaRestGrpcServerRequest $argument,
      $metadata = [], $options = []) {
        return $this->_simpleRequest('/com.migration.poc.JavaRestGrpcServerService/send',
        $argument,
        ['\Com\Migration\Poc\JavaRestGrpcServerReply', 'decode'],
        $metadata, $options);
    }

}
