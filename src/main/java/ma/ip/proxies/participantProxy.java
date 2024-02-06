package ma.ip.proxies;


import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "participant-service",
        url = "${participant.api.url:}")
public interface participantProxy {


}
