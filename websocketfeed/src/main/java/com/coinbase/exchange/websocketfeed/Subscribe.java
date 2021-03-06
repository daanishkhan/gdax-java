package com.coinbase.exchange.websocketfeed;

import static com.coinbase.exchange.websocketfeed.ChannelName.full;

/**
 * To begin receiving feed messages, you must first send a subscribe message
 * indicating which channels and products to receive.
 * Example:
 * Subscribe to ETH-USD and ETH-EUR with the level2, heartbeat and ticker channels,
 * plus receive the ticker entries for ETH-BTC and ETH-USD
 * <pre>
 * {
 *   "type": "subscribe",
 *   "product_ids": [
 *     "ETH-USD",
 *     "ETH-EUR"
 *   ],
 *   "channels": [
 *     "level2",
 *     "heartbeat",
 *     {
 *       "name": "ticker",
 *       "product_ids": [
 *         "ETH-BTC",
 *         "ETH-USD"
 *       ]
 *     }
 *   ]
 * }
 * </pre>
 *
 * See docs https://docs.pro.coinbase.com/#subscribe
 */
public class Subscribe {

    private final static String SUBSCRIBE_MSG_TYPE = "subscribe";

    private String type = SUBSCRIBE_MSG_TYPE;
    private String[] product_ids;
    private Channel[] channels;

    // Used for signing the subscribe message to the Websocket feed
    private String signature;
    private String passphrase;
    private String timestamp;
    private String apiKey;

    public Subscribe() { }

    public Subscribe(String[] product_ids) {
        this.product_ids = product_ids;
        this.channels = new Channel[]{new Channel(full, product_ids)};
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getProduct_ids() {
        return product_ids;
    }

    public void setProduct_ids(String[] product_ids) {
        this.product_ids = product_ids;
    }

    public Subscribe setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public Subscribe setPassphrase(String passphrase) {
        this.passphrase = passphrase;
        return this;
    }

    public Subscribe setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Subscribe setKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public void setChannels(Channel[] channels) {
        this.channels = channels;
    }

    public Channel[] getChannels() {
        return channels;
    }
}
